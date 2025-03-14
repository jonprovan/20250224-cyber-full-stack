import logo from './logo.svg';
// importing an external stylesheet
// you can import any others you like here or in any sub-component
import './App.css';
import { Header } from './components/Header';

// each component is a function
function App() {
  return (
    <>
      {/* inserting our Header component directly here */}
      <Header />
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
