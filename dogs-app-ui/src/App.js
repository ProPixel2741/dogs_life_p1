import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar'; 
import AllDogs from './components/AllDogs';
import { Route, Routes } from 'react-router-dom';
import DogDetail from './components/DogDetail';

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Dogs</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/alldogs">All Dogs</Nav.Link>
              <Nav.Link href="/:id">Dog Details</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Routes>
        <Route path="/alldogs" element={<AllDogs/>} />
        {/*<Route path="/:id" element={<DogDetail/>} />*/}
        <Route path="/" element={<AllDogs/>} />
      </Routes>
      </>
  );
}

export default App;
