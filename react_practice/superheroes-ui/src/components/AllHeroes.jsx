import React from 'react'
import HeroDetails from './HeroDetails'

const AllHeroes = () => {
    const heros = [{
        "id": 1,
        "name": "Bruce Wayne",
        "alias": "Batman",
        "superpower": "Martial Arts",
        "teamID": 1
    }]
        
    return (
        heroes.map(hero => (
            <HeroDetails info={hero} key={hero.id.toString()}/>
        ))
        
    )
}

export default AllHeroes