export class Ingredient {
    id: number;
    ingredientName: string;
    ingredientType: string;

    constructor(id: number, ingredientName: string, ingredientType: string) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }
}