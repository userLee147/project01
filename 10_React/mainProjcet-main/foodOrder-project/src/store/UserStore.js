import { create } from 'zustand';
import axios from 'axios';

const useUserStore = create((set, get) => ({
  users: [],
  currentUser: null,
  loading: false,
  error: null,
  


  login: async (id, pwd) => {
    
    try {
      const response = await axios.get('http://localhost:3001/usersDB', {
        params: { id, pwd },
      })
      
      if (response.data.length > 0 ) {
        const user = response.data[0]
    
        await axios.patch(`http://localhost:3001/usersDB/${user.id}`, {
          log: true,
        });

        set({ currentUser : { ...user, log: true }, error: null });
       
      }else{
        throw new Error('아이디 또는 비밀번호가 일치하지 않습니다.')
      }
    } catch (error) {
      set({ currentUser: [], error: error.message });
      throw error;
    }
  },
  logout : async (currentUser) => {
  
    const id = currentUser.id
   
    await axios.patch(`http://localhost:3001/usersDB/${id}`,{
      log : false,
    })
    set({...currentUser, log: false})
    set({currentUser : null})
  },

  addUser : async (data) => {
  
    await axios.post(`http://localhost:3001/usersDB/`,data)
    .then((res) =>  res )
    .catch((error) => error)
  },

  updateUser: async (updateUser) => {
    const id = updateUser.id
     await axios.patch(`http://localhost:3001/usersDB/${id}`,{...updateUser} );

  },
  getUser : async (id) => {
    const res = await axios.patch(`http://localhost:3001/usersDB/${id}`)
    const user = res.data[0]
    set({ currentUser : { ...user, log: true }, error: null });
  },

  deleteUser : async (id) => {
      await axios.delete(`http://localhost:3001/usersDB/${id}`)
  }
}));

export default useUserStore;
