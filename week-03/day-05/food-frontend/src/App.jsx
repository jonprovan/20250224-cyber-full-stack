// importing an external stylesheet
// you can import any others you like here or in any sub-component
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router';
import { Frame } from './pages/Frame';
import { Bios } from './pages/Bios';
import { Categories } from './pages/Categories';
import { Cooks } from './pages/Cooks';
import { Ingredients } from './pages/Ingredients';
import { Recipes } from './pages/Recipes';

// each component is a function
function App() {
  return (
    <>
      {/* we wrap our content in the BrowserRouter to enable SPA routing for pages */}
      <BrowserRouter>
        {/* inside the BrowserRouter, we lay out individual routes */}
        <Routes>
          {/* each route specifies a path and a component to route to the outlet
              when the path is either entered by the user or triggered internally */}
          <Route path="/" element={<Frame/>}>
            {/* these nested routes will retain the prefix from the parent route */}
            <Route index element={<Bios/>}/>
            <Route path="bios" element={<Bios/>}/>
            <Route path="categories" element={<Categories/>}/>
            <Route path="cooks" element={<Cooks/>}/>
            <Route path="ingredients" element={<Ingredients/>}/>
            <Route path="recipes" element={<Recipes/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>


    // the return from a component function MUST be contained in a single tag
    // if you don't have a containing parent tag, you can wrap multiple tags
    // up into an empty tag <> </>
    // note the different naming convention for the CSS class property
    // note also the curly braces around the img tag's src property
    // this is drawing in a value from our JS, i.e. the imported logo image
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>
  );
}

// this is one way of exporting a function to be imported elsewhere
export default App;
