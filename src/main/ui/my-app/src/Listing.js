import React, { Component } from 'react';
// import React, { useEffect, useEstate} from 'react';

// function getUsers() {
//     const [name, setName] = useState("")
//     const [id, setId] = useState(null)
//     const [address, setAddress] = useState("")
//     const [phone, setPhone] = useState("")

// }


function deleteCustomer(id)
    {   
        fetch(`http://localhost:8080/customers/${id}`,{
            method:'DELETE'
        }).then((result)=>{
            result.json().then((resp)=>{
                console.warn(resp)

            })
        }) 
    }

function selectCustomer()
{
    console.warn("function called")
}

class Listing extends Component {

    

    constructor(props) {
        super(props)   
        this.state = {
            customers: []
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/customers/')
            .then(response => response.json())
            .then(customers => {
                this.setState({
                    customers: customers
                })
            })
            .catch(error => console.log(error))
    }
    
   
    
    renderListing() {
        let customerList = []
        this.state.customers.map(customer => {
            return customerList.push(
            <table border="1"> 
            <tr key={customer.id}>
                <td>{customer.id}</td>
               <td> {customer.name}</td>
               <td> {customer.phone} </td>
               <td> {customer.address} </td>
               <td><button onClick={()=>deleteCustomer(customer.id)}>Delete</button></td>
               <td><button onClick={()=>selectCustomer(customer.id)}>Select</button></td>
            </tr>                            
            </table>

                
            


            )

        })

        return customerList;
    }

    render() {
        return (
            <div>
                {this.renderListing()}
            </div>
        );
    }
}

export default Listing;