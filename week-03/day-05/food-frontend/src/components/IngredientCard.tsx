import React, { useContext, useRef, useState } from "react";
import { FavoriteContext } from "../pages/Frame";
import { Ingredient } from "../models/Ingredient.ts";
// import { useNavigate } from "react-router";
// import { Ingredient } from "../models/Ingredient";

export const IngredientCard = (props: any) => {

    // our props object is pretty generic, but if we draw things out of it, we can type those
    // const ingredient: Ingredient = props.ingredient;

    // using our FavoriteContext and skipping the first index, since we only need the setter
    const [ , setFavorite ] = useContext(FavoriteContext);

    const [ visible, setVisible ] = useState(false);

    const updateFormName: any = useRef('');
    const updateFormType: any = useRef('');

    // you can use useNavigate() to move from one "page" to another when a function is called
    // you need to have whatever routes set up already
    // set it like this at the root level of the component
    // then call navigate('<route>') within a method, feeding in whatever route you like
    // const navigate = useNavigate();

    const update = async (event: any): Promise<void> => {
        event.preventDefault();
        await props.updateIngredient(new Ingredient(props.ingredient.id,
                                              updateFormName.current.value,
                                              updateFormType.current.value));
        setVisible(!visible);
        // navigate('/bios');
    }

    return(
        <div className="ingredient">
            <h3>{ props.ingredient.ingredientName }</h3>
            <ul>
                <li>ID: { props.ingredient.id }</li>
                <li>Type: { props.ingredient.ingredientType }</li>
            </ul>

            <form onSubmit={update} style={{ visibility: visible ? 'visible' : 'hidden',
                                             height: visible ? 'auto' : '0px',
                                             marginBottom: '8px' }}>
                <h3>Update Ingredient</h3>
                <div>
                    <label htmlFor="updateFormName">Name: </label>
                    <input type="text" id="updateFormName" name="updateFormName" 
                           defaultValue={props.ingredient.ingredientName} ref={updateFormName} />
                </div>
                <div>
                    <label htmlFor="updateFormType">Type: </label>
                    <input type="text" id="updateFormType" name="updateFormType" 
                           defaultValue={props.ingredient.ingredientType} ref={updateFormType} />
                </div>
                {/* React often uses this different syntax for a submit button */}
                <input type="submit" value={'Submit'} />
            </form>

            {/* we can now call context methods directly */}
            <button onClick={() => setVisible(!visible)}>{visible ? 'Hide' : 'Update'}</button>
            <button onClick={() => setFavorite(props.ingredient.ingredientName)}>Fave</button>
            <button onClick={() => setFavorite('')}>Clear</button>
            <button onClick={() => props.deleteIngredient(props.ingredient.id)}>X</button>
        </div>
    );

}