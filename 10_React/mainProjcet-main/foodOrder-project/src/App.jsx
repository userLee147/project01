import './App.css';

import { BrowserRouter, Routes, Route } from 'react-router-dom';
import MainPage from './pages/MainPage';
import Login from './pages/Login';
import UserRegistration from './pages/UserRegistration';
import SearchMenu from './pages/SearchMenu';
import DetailMenu from './pages/DetailMenu';
import MenuList from './pages/MenuList';
import MenuOrder from './pages/MenuOrder';
import UserPage from './pages/UserPage';
import UserEdit from './pages/UserEdit';
import OrderList from './pages/OrderList';
function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainPage />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/user" element={<UserRegistration />}></Route>
          <Route path="/userEdit" element={<UserEdit />}></Route>
          <Route path="/user/:id" element={<UserPage />} />
          <Route path="/search" element={<SearchMenu />}></Route>
          <Route path="/detail/:id" element={<DetailMenu />}></Route>
          <Route path="/menu" element={<MenuList />} />
          <Route path="/order" element={<MenuOrder />} />
          <Route path="/order/:id" element={<OrderList />} />

          {/*<Route path="*" element={<NotFound />} /> } */}
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
