import React from 'react';
import { Route, Routes } from 'react-router-dom';
import HomePage from './home/HomePage';
import Header from './common/Header';
import PagesPage from './codexpages/PagesPage';
import TimelinesPage from './timelines/TimelinesPage';
import { Container } from '@mui/material';

function App() {
  return (
    <div>
      <Header />
      
      <Container sx={{ m: 2 }}>
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/pages" element={<PagesPage />} />
          <Route path="/timelines" element={<TimelinesPage />} />
        </Routes>
      </Container>
    </div>
  )
}

export default App;