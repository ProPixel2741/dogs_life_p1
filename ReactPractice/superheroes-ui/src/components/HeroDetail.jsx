import React from 'react'
import batman from '../images/batman.jpg'
import images from '../index.js'
const HeroDetail = (props) => {
  return (
    <div>
        <img src={images[props.info.alias.replaceAll(/\s/g,'')]} alt={props.info.name} height="250px"/>
        <p id="blue-alias">Alias: Batman</p>
        <p className="green-class">Name: Bruce Wayne</p>
        <button className="green-class">Like</button>
    </div>
  )
}

export default HeroDetail