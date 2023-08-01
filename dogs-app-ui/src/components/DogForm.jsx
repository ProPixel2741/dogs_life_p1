import React from 'react'
import { Form } from 'react-router-dom';
import { useState } from 'react';
import Row from 'react-bootstrap/esm/Row';
import { Button } from 'bootstrap';
import { addDog } from '../services/dog-service';

const DogForm = () => {

  const [name, setName] = useState('');
  const [age, setAge] = useState(0);
  const [owner, setOwner] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    let dog = {};
    dog.name = name;
    dog.age = age;
    dog.owner = owner;
    addDog(dog)
      .then(res => {
        setName('');
        setAge(0);
        setOwner('');
      })
      .catch(err => {
        console.log(err);
      })
  }

  return (
    <Row>
      <Form>
        <Form.Group>
          <Form.Label>Name: </Form.Label>
          <Form.Control type="text" value={name} />
        </Form.Group>
        <Form.Group>
          <Form.Label>Age: </Form.Label>
          <Form.Control type="text" value={age} />
        </Form.Group>
        <Form.Group>
          <Form.Label>Owner: </Form.Label>
          <Form.Control type="text" value={owner} />
        </Form.Group>
        <Button variant="primary" type="submit" onChange={handleSubmit}>Submit</Button>
      </Form>
    </Row>
  )
}

export default DogForm