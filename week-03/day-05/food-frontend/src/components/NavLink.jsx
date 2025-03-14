import { Link } from "react-router";

// here, we fill the parentheses with a name we wish to call the collected properties
// as passed down by the parent
// the parent will pass an object with each named property as a prop of the object
// here, we're deconstructing the object on input to directly access the linkObject variable
// you could also say export const NavLink = (props) => {}
// then, you'd just refer to the linkObject as props.linkObject
// the incoming object variable can be named whatever you want!
export const NavLink = ({ linkObject }) => {
    
    // further deconstruction to shorten the HTML section
    const { linkDestination, linkName } = linkObject;

    // using the properties from the parent to fill the Link values
    return (
        <Link to={ linkDestination }>{ linkName }</Link>
    );
}