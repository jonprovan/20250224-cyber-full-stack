export const IngredientCard = (props) => {

    return(
        <div className="ingredient">
            <h3>{ props.ingredient.ingredientName }</h3>
            <ul>
                <li>ID: { props.ingredient.id }</li>
                <li>Type: { props.ingredient.ingredientType }</li>
            </ul>
            <button onClick={() => props.deleteIngredient(props.ingredient.id)}>Delete Ingredient</button>
        </div>
    );

}