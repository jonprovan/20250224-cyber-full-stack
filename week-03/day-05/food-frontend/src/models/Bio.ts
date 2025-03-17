// this is now a TypeScript file
// we can type our variables to restrict what is allowed to be stored in them
export class Bio {
    // after the variable name, use a colon, then the type
    id: number;
    cookDescription: string;

    // have to do this with intake variables as well
    constructor(id: number, cookDescription: string) {
        this.id = id;
        this.cookDescription = cookDescription;
    }
}