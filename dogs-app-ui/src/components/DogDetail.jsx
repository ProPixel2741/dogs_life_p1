import React from 'react'
import {useParams} from 'react-router-dom'
import { useState, useEffect } from 'react'
import { getDogInfo } from '../services/dog-service'
import Card from 'react-bootstrap/Card';


const DogDetail = () => {
    const params = useParams();
    const [data, setData] = useState({})

    const getDogDataFromAPI = () => {
        getDogInfo(params.id)
            .then(res => {
                setData(res.data)
                console.log(res.data)
            })
            .catch(err => {
                setData({})
                console.log(err)
            })
    }

    useEffect(() => {
        getDogDataFromAPI();
    })

    return (
        <Card>
            <Card.Body>
                <Card.Title>Name:{data.name}</Card.Title>
                <Card.Text>Age:{data.age}</Card.Text>
                <Card.Text>Owner:{data.owner}</Card.Text>
            </Card.Body>
        </Card>
    )
}

export default DogDetail