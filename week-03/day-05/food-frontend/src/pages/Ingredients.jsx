import axios from 'axios';
import { useState } from 'react';
import { Ingredient } from '../models/Ingredient';
import { IngredientCard } from '../components/IngredientCard';

export const Ingredients = () => {

    const [ ingredients, setIngredients ] = useState([]);

    const getAllIngredients = async () => {
        await axios.get('http://localhost:8080/ingredient')
                   .then(response => {
                        setIngredients(response.data.map(ingredient => {
                            return new Ingredient(ingredient.id, 
                                                  ingredient.ingredientName, 
                                                  ingredient.ingredientType);
                        }));
                   });
    }

    // a delete function that we're going to call from the child
    // the state of the ingredients array is maintained here
    // so, even if we deleted the record from the database in the child
    // the display would not reflect it
    const deleteIngredient = async (id) => {
        await axios.delete(`http://localhost:8080/ingredient/${id}`)
                   .then(async () => {
                        await getAllIngredients();
                   });
    }

    return(
        <main>
            <h1>Ingredients</h1>

            <div>
                <button onClick={() => getAllIngredients()}>GET ALL</button>
            </div>

            {
                ingredients.map(ingredient => {
                    return (<IngredientCard ingredient={ingredient}
                                            deleteIngredient={deleteIngredient}
                                            key={ingredient.id} />)
                })
            }

        </main>
    )
}