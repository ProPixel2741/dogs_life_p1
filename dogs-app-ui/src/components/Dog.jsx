import React from 'react'
import {useParams} from 'react-router-dom'
import { useState, useEffect } from 'react'
import { getDogInfo } from '../services/dog-service'


const Dog = () => {
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
    }, [])

    return (
        <div>
            <h1>{data.name}</h1>
            <h2>Age: {data.age}</h2>
            <h2>Owner: {data.owner}</h2>
        </div>
    )
}

export default Dog