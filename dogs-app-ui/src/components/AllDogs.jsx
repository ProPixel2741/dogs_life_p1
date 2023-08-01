import React from 'react'
import Row from 'react-bootstrap/Row'
import { useState, useEffect } from 'react'
import { getAllDogs } from '../services/dog-service'


const AllDogs = () => {

    const [dogs, setDogs] = useState([]);

    const getDogsFromAPI = () => {
        getAllDogs()
            .then(res => {
                setDogs(res.data);
            })
            .catch(err => {
                setDogs([]);
                console.log(err);
            })
    };
    
    useEffect(() => {
        getDogsFromAPI();},
        []
    );

    return (
    <>
        <h1>Total count is: </h1>
        <Row>
            {dogs.map(dog=>(
                <a className="container" key={dog.id} href={'http://localhost:3000/' + dog.id}>{dog.name}</a>
            ))}
        </Row>
    </>
    )
}

export default AllDogs