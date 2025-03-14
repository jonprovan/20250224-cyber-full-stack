// importing this to make our API requests
import axios from 'axios';
import { useState } from 'react';
import { Bio } from '../models/Bio';

// this component includes a table of all our DB Bios
// we're using our local model for a Bio
// we're not using a separate component for each row, just coding in the row directly
export const Bios = () => {

    // using useState to keep track of and update this component's knowledge
    // of our Bios' state
    // if we don't do this, it's possible something about state will change
    // and it won't be reflected on screen
    // the first variable is the name for the value
    // the second is the name for the value's setter
    const [ bios, setBios ] = useState([]);

    const getAllBios = async () => {
        await axios.get('http://localhost:8080/bio')
                   .then(response => {
                        setBios(response.data.map(bio => {
                            return {
                                bio: new Bio(bio.id, bio.cookDescription),
                                cookName: bio.cook?.firstName
                            }
                        }));
                   });
    }

    return(
        <main>
            <h1>Bios</h1>

            {/* clicking this button will run our get all method */}
            <button onClick={ () => getAllBios() }>GET ALL</button>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Cook Name</th>
                        <th>Cook Description</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        bios.map(bio => {
                            return (
                                <tr key={ bio.bio.id }>
                                    <td>{ bio.bio.id }</td>
                                    <td>{ bio.cookName }</td>
                                    <td>{ bio.bio.cookDescription }</td>
                                </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </main>
    )
}