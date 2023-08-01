import React from 'react'
import { useState, useEffect } from 'react'
import { getDogCount } from '../services/dog-service'

const DogCount = () => {
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
        <div>Total dogs= {count}</div>
    )
}

export default DogCount
