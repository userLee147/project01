import React, { createContext, useContext, useState } from 'react'

const UserContext = createContext();

const initialUsers = [{
    id: 1,
    img: "/public/static/iconmonstr-user-circle-thin-240.png",
    name: "user1",
    age: 20,
    department: "회계",
    login: false,
    
},
{
    id: 2,
    img: "/public/static/iconmonstr-user-circle-thin-240.png",
    name: "user2",
    age: 20,
    department: "영업",
    login: false,
},
{
    id:3,
    img: "/public/static/iconmonstr-user-circle-thin-240.png",
    name: "user3",
    age: 20,
    department: "전산",
    login: false,
},
{
    id: 4,
    img: "/public/static/iconmonstr-user-circle-thin-240.png",
    name: "user4",
    age: 20,
    department: "행정",
    login: false,
}
]

export function UserProvider({children}){

    const [users, setUsers] = useState(initialUsers);

    const deleteUser = (userId) => {
        setUsers(users.filter(user => user.id !== userId));
      };
    
      const getUserById = (userId) => {
        return users.find(user => user.id === userId);
      };

    return(
        <UserContext.Provider value={{users ,setUsers, deleteUser, getUserById}}>
            {children}
        </UserContext.Provider>
    )
}

export function useUser(){
    return useContext(UserContext)
        
}
