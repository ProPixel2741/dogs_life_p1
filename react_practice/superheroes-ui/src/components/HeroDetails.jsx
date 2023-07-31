import React from 'react'

const HeroDetails = (props) => {
  return (
    <div>
        <img src="images/blogo.jpg" alt="batman" height="250px"/>
        <p id="blue-alias">Alias: {props.info.alias}</p>
        <p class="green-class">Name: {props.info.name}</p>
        <button class="green-class">Like</button>
    </div>
  )
}

export default HeroDetails