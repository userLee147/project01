import './App.css';
import Insert from './component/Insert';
import { ToastContainer, toast } from 'react-toastify';
import { useState } from 'react';
import { performToast } from './component/performToast';

performToast({ msg: '요청에 성공하였습니다.1', type: 'success' });

function App() {
  const notify = () => toast('Wow so easy !');
  return (
    <>
      <Insert></Insert>

        <ToastContainer />
      
    </>
  );
}

export default App;
