import logo from './logo.svg';
import './App.css';
import {Routes, Route} from 'react-router-dom';

import DogList from './components/DogList';
import Dog from './components/Dog'


function App() {
  return (
    <Routes>
      <Route path='/' element={<DogList/>}/>
      <Route path='/:id' element={<Dog/>}/>
    </Routes>
  );
}

export default App;
