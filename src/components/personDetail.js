// src/components/KisiDetayi.js
import React, { useState, useEffect } from 'react';
import api from '../api';
import { useParams } from 'react-router-dom';

function personDetail() {
    const [person, setPerson] = useState({});
    const { id } = useParams();

    useEffect(() => {
        fetchPerson();
    }, [id]);

    const fetchPerson = async () => {
        const response = await api.get(`/${id}`);
        setPerson(response.data);
    };

    return (
        <div>
            <h2>Person Detail</h2>
            <p>firstName: {person.firstName}</p>
            <p>lastName: {person.lastName}</p>
            <p>birthDay: {person.birthDay}</p>
            <p>gender: {person.gender}</p>
            <p>favouriteTeam: {person.favouriteTeam}</p>
        </div>
    );
}

export default personDetail;
