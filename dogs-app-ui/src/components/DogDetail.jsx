import React from 'react'
import Card from 'react-bootstrap/Card'
import { useState, useEffect } from 'react'
import { getAllDogs } from '../services/dog-service'
import { useParams } from 'react-router-dom'

const DogDetail = () => {

    const params = useParams();

    const [data, setData] = useState({});

    const getDogsFromAPI = () => {
        getAllDogs()
            .then(res => {
                setData(res.data);
            })
            .catch(err => {
                setData({});
                console.log(err);
            })
    };

    useEffect(() => {
        getDogsFromAPI();},
        []
    );

    return (
    <Card>
        <Card.Body>
            <Card.Title>Name: {data.name}</Card.Title>
            <Card.Text>Age: {data.age}</Card.Text>
            <Card.Text>Owner: {data.owner}</Card.Text>
        </Card.Body>
    </Card>
    )
}

export default DogDetail