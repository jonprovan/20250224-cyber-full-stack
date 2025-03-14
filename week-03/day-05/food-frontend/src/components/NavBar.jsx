export const NavBar = () => {

    // imagine we drew this data from a DB and had it stored locally here
    const links = [
        { linkName: "Bios", linkDestination: "/bios" },
        { linkName: "Categories", linkDestination: "/categories" },
        { linkName: "Cooks", linkDestination: "/cooks" },
        { linkName: "Ingredients", linkDestination: "/ingredients" },
        { linkName: "Recipes", linkDestination: "/recipes" }
    ]

    return (
        <nav>
            {/* you can loop through JS objects to return multiple elements
                the map function is perfect for this */}
            { links.map(link => {
                return (<a href={ link.linkDestination }>{ link.linkName }</a>)
            }) }
        </nav>
    );
}