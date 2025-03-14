import { Header } from "../components/Header";
import { Outlet } from 'react-router';

export const Frame = () => {
    return (
        <>
            {/* our Header component is placed here normally */}
            <Header />
            {/* this is where any page component we link to will appear  */}
            <Outlet />
        </>
    );
}