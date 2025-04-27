import React from 'react'
import { useNavigate } from 'react-router-dom'
import styled from 'styled-components'

const CardDiv = styled.div`
    height: 100px;
    display: flex;
    margin: 10px;

    border: 1px solid #c5c5c5;
    background-color: white;
    border-radius: 8px;


`
const Img = styled.img`
    width: 50px;
    height: 50px;
    margin: 20px;

`
const ItemDiv = styled.div`
    text-align: left;
    justify-content: center;
    margin: auto 10px ;
`


const Useritem = ({userItem}) => {
    const navigator = useNavigate();

    const handleClick =() =>{
        navigator(`/user/${userItem.id}`)
    }

  return (
    <CardDiv onClick={() => handleClick()}>
        <div>
            <Img src={userItem.img} alt="" />
        </div>
        <ItemDiv>
            <p>{userItem.login ? "🟢 온라인" : "🔴 오프라인"}</p>
            <p><strong>이름&emsp;</strong>{userItem.name}</p>
            <p><strong>부서&emsp;</strong>{userItem.department}</p> 
                      
        </ItemDiv>
    </CardDiv>
  )
}

export default Useritem