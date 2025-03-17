import { createContext, useState } from "react";
import { Header } from "../components/Header.tsx";
import { Outlet } from 'react-router';

// creating an importable Context we can use for communication between unrelated components
// we want to avoid prop drilling -- sending info through components that don't need it
// we'll establish state/functionality here
export const FavoriteContext = createContext();

export const Frame = () => {

    const [ favorite, setFavorite ] = useState('');

    return (
        <>
            {/* wrap whatever content you wish to have context access into this tag */}
            {/* we also set as the value anything we wish to pass to the context */}
            {/* to pass more than one thing, use an object with props or an array */}
            <FavoriteContext.Provider value={[favorite, setFavorite]}>
                {/* our Header component is placed here normally */}
                <Header />
                {/* this is where any page component we link to will appear  */}
                <Outlet />
            </FavoriteContext.Provider>

            {/* if we had other components OUTSIDE of the provider tag, they wouldnt' have access */}
            {/* <ComponentX /> */}
        </>
    );
}