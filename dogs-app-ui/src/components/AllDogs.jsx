import React from 'react'
import { useState, useEffect } from 'react'
import { getAllDogs } from '../services/dog-service'
import DogCount from './DogCount'

const AllDogs = () => {

    const [dogs, setDogs] = useState([])

    const getAllDogsFromAPI = () => {
        getAllDogs()
            .then(res => {
                setDogs(res.data)
                console.log(res.data)
            })
            .catch(err => {
                setDogs([])
                console.log(err)
            })
    }

    useEffect(() => {
        getAllDogsFromAPI();
    }, [])

    const style = {display: "flex", direction: "row", gap: "80px"} 

    return (
        <div>
            <DogCount/>
            <div style={style}>
                {dogs.map(dog=> (
                        <a key={dog.id} href={'http://localhost:3000/' + dog.id}>{dog.name}</a>
                    ))
                }
            </div>
            
        </div>
    )
}

export default AllDogs