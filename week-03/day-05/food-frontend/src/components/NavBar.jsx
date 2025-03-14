// import { Link } from 'react-router';
import { NavLink } from './NavLink';

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
                // instead of using an a tag, which would navigate the browser
                // to a new location
                // we use react-router's Link to send content to the Outlet
                
                // we can manually enter the Link objects here
                // return (<Link to={ link.linkDestination }>{ link.linkName }</Link>);

                // or, we can pass data down to a child component
                // the name of the property is whatever you want
                // the child will receive something with that name
                // the value in the braces is whatever you're feeding down into that prop
                // whenever you loop through and create multiple components
                // React wants you to supply a unique key
                // usually, you can use the DB id for this
                // this way, when the state of components is changing, React can keep track of them
                return (<NavLink linkObject={ link } key={ link.linkName } />)
            }) }
        </nav>
    );
}