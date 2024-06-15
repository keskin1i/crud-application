// src/components/KisiFormu.js
import React, { useState, useEffect } from 'react';
import api from '../api';
import { useHistory, useParams } from 'react-router-dom';

function personForm() {
    const [person, setPerson] = useState({ firstName: '', lastName: '', birthDay: '', gender: '', favouriteTeam: '' });
    const history = useHistory();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            fetchPerson();
        }
    }, [id]);

    const fetchPerson = async () => {
        const response = await api.get(`/${id}`);
        setPerson(response.data);
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setPerson({ ...person, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (id) {
            await api.put(`/${id}`, person);
        } else {
            await api.post('/', person);
        }
        history.push('/');
    };

    return (
        <div>
            <h2>{id ? 'Update Contact' : 'Add New Person'}</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>firstName</label>
                    <input type="text" name="firstName" value={person.firstName} onChange={handleChange} required />
                </div>
                <div>
                    <label>lastName</label>
                    <input type="text" name="lastName" value={person.lastName} onChange={handleChange} required />
                </div>
                <div>
                    <label>birthDay</label>
                    <input type="date" name="birthDay" value={person.birthDay} onChange={handleChange} required />
                </div>
                <div>
                    <label>gender</label>
                    <input type="text" name="gender" value={person.gender} onChange={handleChange} required />
                </div>
                <div>
                    <label>favouriteTeam</label>
                    <input type="text" name="favouriteTeam" value={person.favouriteTeam} onChange={handleChange} required />
                </div>
                <button type="submit">Save</button>
            </form>
        </div>
    );
}

export default personForm;
