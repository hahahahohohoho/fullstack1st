import React, {useState} from 'react'
export default function DisplayData() {
    const [dataBoard, setDataBoard] = useState([]);


//CRUD 메서드 구현
    // fetch
    const loadBoard = async ()=>{
        await fetch('http://localhost:8080/board',{
        })
        .then(resp=> {
            return resp.json();
        }).then(result =>{
            setDataBoard(result)
        }).catch(error=>{
            console.error("Error fetching Board :", error);
        })
    }
    //DELETE
    const deleteId1 = ()=>{
        if(window.confirm("삭제하시겠습니까?")){
            fetch('http://localhost:8080/board/1',{
                method : 'DELETE'
            }).then(res=>{
                if(res.ok){
                    setDataBoard();
                }
            })

        }
    }
    //POST
    const addBoard = async()=>{
        const response = await fetch('http://localhost:8080/board', {
            method : 'POST',
            headers : {
                'Content-Type' : 'application/json',
                // 'Authorization' : 'jwt-token'
            },
            body : JSON.stringify({
                id : 12,
                content : 'test2',
                title : 'test',
                writer : 'tester'
            })
        })
        const data = await response.json();
        setDataBoard([...DisplayData, data])
    }
    const loadData = ()=>{return(
            <table align='center'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>title</th>
                        <th>writer</th>
                        <th>content</th>
                        <th>createDate</th>
                    </tr>
                </thead>
                <tbody>
                    {dataBoard.map(board =>(
                        <tr key={board.id}>
                            <td>{board.title}</td>
                            <td>{board.writer}</td>
                            <td>{board.content}</td>
                            <td>{board.createDate}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
    )}
    return (
        <div>
        <h2>DataDisplay</h2>
        <button onClick={()=>loadBoard()}>Board</button>
        <div>{loadData()}</div>
        <button onClick={()=>deleteId1()} id='board1'>1삭제</button>
        <form id='form' onClick={addBoard}>
            <div>
                <label>아이디 : </label>
                <input name='id'></input>
            </div>  
            <div>
                <label>제목 : </label>
                <input name='title'></input>
            </div>
            <div>
                <label>내용 : </label>
                <textarea name='content'></textarea>
            </div>
            <button type='submit'>제출하기</button>
        </form>
    </div>
  )
}


