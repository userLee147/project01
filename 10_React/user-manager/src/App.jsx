import { useContext, useState } from 'react'
import './App.css'
import { BrowserRouter, Route, Routes,Link } from 'react-router-dom'
import UserList from './pages/UserList'
import NotFound from './pages/NotFound'
import UserDetail from './pages/UserDetail'
import UserRegistration from './pages/UserRegistration'
import { UserProvider } from './components/context/UserContext'
import { ThemeContext } from './components/context/ThemeContext'

function App() {
  const [isDark , setIsDark] = useState(false)

  return (
    <>
    
      <UserProvider>
      <ThemeContext.Provider value={{isDark, setIsDark}}>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<UserList/>} />
            <Route path='/user' element={<UserRegistration/>} />
            <Route path='/user/:id' element={<UserDetail/>} />
            <Route path='*' element={<NotFound/>} />
          </Routes>
          </BrowserRouter>
        </ThemeContext.Provider>
    </UserProvider>




    </>
  )
}

export default App
