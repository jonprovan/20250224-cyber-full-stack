import { NavBar } from "./NavBar";
// importing a custom stylesheet for this component and any components nested in it
// NOTE -- this seems to apply globally...will take a look!
import '../css/header.css';

// this will be a component that we can import elsewhere
// it is NOT a page we will route to and will be included on every "page"
export const Header = () => {
    return (
        <header>
            REACT APP FOR THE FOOD API
            <NavBar />
        </header>
    );
}