import { NavBar } from "./NavBar";
// importing a custom stylesheet for this component and any components nested in it
// NOTE -- this seems to apply globally...will take a look!
import '../css/header.css';
import React, { useContext } from "react";
import { FavoriteContext } from "../pages/Frame";

// this will be a component that we can import elsewhere
// it is NOT a page we will route to and will be included on every "page"
export const Header = () => {

    // importing our context and only grabbing the value, since we don't need the setter
    const [ favorite ] = useContext(FavoriteContext);

    return (
        <header>
            REACT APP FOR THE FOOD API
            {/* we can now grab the context value directly */}
            {/* dynamically adjusting styles if the favorite is populated */}
            <div style={{ height: favorite ? '24px' : '0px', 
                          visibility: favorite ? 'visible' : 'hidden' }}>
                {'Favorite: ' + favorite}
            </div>
            <NavBar />
        </header>
    );
}