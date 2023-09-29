import * as React from 'react';
import { AppBar, Box, Button, Container, Toolbar, Typography } from '@mui/material';
import { Link } from 'react-router-dom';

const pages = [
  {
    key: 'pages',
    title: 'Pages',
    url: '/pages',
  },
  {
    key: 'timelines',
    title: 'Timelines',
    url: '/timelines',
  },
]

export default function Header() {
  return (
    <AppBar position="static">
      <Container maxWidth={false}>
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ mr: 2 }}>
            Codex
          </Typography>
          
          <Box>

            {
              pages.map( (page) => 
                <Link to={page.url} key={`${page.key}-link`}>
                  <Button key={`${page.key}-button`} sx={{ my: 2, ml: 1, color: 'white' }}>
                    {page.title}
                  </Button>
                </Link>
              )
            }

          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}