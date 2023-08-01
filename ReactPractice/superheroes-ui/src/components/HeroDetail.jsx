import React, { useState } from 'react';
import batman from '../images/batman.jpg';
import images from '../index.js';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Col from 'react-bootstrap/Col'; // Import Col from react-bootstrap
import Row from 'react-bootstrap/Row';
const HeroDetail = (props) => {
  const[counter, setCounter] = useState(0);
  const incrementCounter =()=>{
    setCounter(counter+1);
    props.parentCount(props.info.alias);
  }

  return (
    <Card>
      <div className="imgContainer">
        <Card.Img variant="top" src={images[props.info.alias.replaceAll(/\s/g, '')]} width="150px" />
      </div>
      <Card.Body>
        <Card.Title>Alias: {props.info.alias}</Card.Title>
        <Card.Text>Name: {props.info.name}</Card.Text>
        <Row>
          <Col>
            <Button variant="primary" onClick={incrementCounter}>Like</Button>
          </Col>
          <Col>
            {/* Use the shorthand notation for conditional rendering */}
            {counter > 0 && <Card.Text>Likes: {counter}</Card.Text>}
          </Col>
        </Row>
      </Card.Body>
    </Card>
  );
  }

export default HeroDetail