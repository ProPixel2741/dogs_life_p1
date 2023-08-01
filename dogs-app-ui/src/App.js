
import './App.css';
import {Routes, Route} from 'react-router-dom';
import DogDetail from './components/DogDetail';
import AllDogs from './components/AllDogs';

function App() {
  return (
    <Routes>
      <Route path='/' element={<AllDogs/>}/>
      <Route path='/:id' element={<DogDetail/>}/>
    </Routes>
  );
}

export default App;
