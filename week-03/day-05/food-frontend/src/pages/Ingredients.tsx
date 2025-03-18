import axios, { AxiosHeaders } from 'axios';
import { useEffect, useRef, useState } from 'react';
import { Ingredient } from '../models/Ingredient.ts';
import { IngredientCard } from '../components/IngredientCard.tsx';
import React from 'react';

export const Ingredients = () => {

    const [ ingredients, setIngredients ] = useState([]);

    // the useEffect hook runs whenever something is rerendered due to a state change
    // we can set it to run once on initial render, or hook it to one or more variables
    // or, we can run it whenever ANYTHING changes
    // the second parameter is the dependency list
    // no value will re-run on EVERY render
    // empty array will run only on the initial render
    // if the array has variable values, it will run only when those change
    useEffect(() => {
        getAllIngredients(null);
    }, []);

    // adding headers here
    const getAllIngredients = async (event: any) => {
        event.preventDefault();

        // create a header object
        let myHeaders: AxiosHeaders = new AxiosHeaders();
        // setting an individual key-value pair for a header
        myHeaders.set('Content-Type', 'application/json');
        myHeaders.set('Authorization', `Basic ${btoa('admin:11235eureka')}`);

        // then attach the headers to your request as part of the config/options block
        // for get/delete, it's the second parameter
        // for post/put, it's the third parameter, after the body
        // you can also attach any query parameters in the options block
        // here, we're using our filter string to add an optional type parameter
        await axios.get('http://localhost:8080/ingredient', { headers: myHeaders,
                                                              params: {
                                                                type: typeFilter.current.value || null
                                                              }
         })
                   .then(response => {
                        setIngredients(response.data.map((ingredient: any) => {
                            return new Ingredient(ingredient.id, 
                                                  ingredient.ingredientName, 
                                                  ingredient.ingredientType);
                        }));
                   }).catch(error => console.log(error));
    }

    // holding our filter string value from the filter form
    const typeFilter: any = useRef('');

    // connecting form fields to JS variables with useRef
    // as the user types/deletes, the field value will be tied to these variables
    const addFormName: any = useRef('');
    const addFormType: any = useRef('');

    // because we're submitting a form, there's a default HTML refresh that occurs
    // we need to take in the event and prevent its default behavior
    // by maintaining the submit functionality, though, the user can "enter" to submit the form
    const addIngredient = async (event: any): Promise<void> => {
        event.preventDefault();
        await axios.post('http://localhost:8080/ingredient',
                         { ingredientName: addFormName.current.value,
                           ingredientType: addFormType.current.value }
        ).then(async () => {
            await getAllIngredients(null);
        })
    }

    const updateIngredient = async (ingredient: Ingredient): Promise<void> => {
        await axios.put(`http://localhost:8080/ingredient/${ingredient.id}`,
                         { ingredientName: ingredient.ingredientName,
                           ingredientType: ingredient.ingredientType }
        ).then(async () => {
            await getAllIngredients(null);
        })
    }

    // a delete function that we're going to call from the child
    // the state of the ingredients array is maintained here
    // so, even if we deleted the record from the database in the child
    // the display would not reflect it
    const deleteIngredient = async (id: number) => {
        await axios.delete(`http://localhost:8080/ingredient/${id}`)
                   .then(async () => {
                        await getAllIngredients(null);
                   });
    }

    return(
        <main>
            <h1>Ingredients</h1>

            {/* don't need this, now that useEffect loads the ingredients when we hit this page */}
            {/* <div>
                <button onClick={() => getAllIngredients()}>GET ALL</button>
            </div> */}

            <form onSubmit={getAllIngredients}>
                <div>
                    <label htmlFor="typeFilter">Type to filter by: </label>
                    <input type="text" id="typeFilter" name="typeFilter" ref={typeFilter} />
                </div>
                <input type="submit" value={'Filter'} />
            </form>

            <form onSubmit={addIngredient}>
                <h3>Add Ingredient</h3>
                <div>
                    <label htmlFor="addFormName">Name: </label>
                    <input type="text" id="addFormName" name="addFormName" ref={addFormName} />
                </div>
                <div>
                    <label htmlFor="addFormType">Type: </label>
                    <input type="text" id="addFormType" name="addFormType" ref={addFormType} />
                </div>
                {/* React often uses this different syntax for a submit button */}
                <input type="submit" value={'Add'} />
            </form>

            {
                ingredients.map((ingredient: Ingredient) => {
                    return (<IngredientCard ingredient={ingredient}
                                            updateIngredient={updateIngredient}
                                            deleteIngredient={deleteIngredient}
                                            key={ingredient.id} />)
                })
            }

        </main>
    )
}