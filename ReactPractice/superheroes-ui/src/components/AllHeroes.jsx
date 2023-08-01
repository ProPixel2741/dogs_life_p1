import React from 'react'
import HeroDetail from './HeroDetail'
import Row from 'react-bootstrap/Row'
import { useState } from 'react'
import { useEffect } from 'react'
import { getAllHeroes } from '../services/hero-service'

const AllHeroes = () => {

  const [heroes, setHeroes] = useState([]);

  useEffect(()=>{
    getHeroesFromAPI();}, 
    []
  );

  const getHeroesFromAPI = ()=>{
    getAllHeroes()
      .then(res => {
        setHeroes(res.data);
      })
      .catch(err => {
        setHeroes([]);
        console.log(err);
      })
  }

  return (
    <>
        <h1>Total count is: </h1>
        <Row>
            {heroes.map(hero=>(
                <div className="container" key={hero.id.toString()}>
                    <HeroDetail info={hero} />
                </div>
            ))}
        </Row>
    </>
  )

}

export default AllHeroes