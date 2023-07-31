import React from 'react'
import { useState, useEffect } from 'react'
import { getDogCount } from '../services/dog-service'

const DogCounter = () => {
    const [count, setCount] = useState(0)

    const getDogCountFromAPI = () => {
        getDogCount()
            .then(res => {
                setCount(res.data)
                console.log(res.data)
            })
            .catch(err => {
                setCount(0)
                console.log(err)
            })
    }

    useEffect(() => {
        getDogCountFromAPI();
    }, [])


    return (
        <div>NUMBER OF DOGS = {count}</div>
    )
}

export default DogCounter