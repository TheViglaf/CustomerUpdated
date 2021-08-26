import './App.css';
import Listing from './Listing'


function App() {
  
    
  function create() {

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/customers/", true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    var fromInputName = document.getElementById( "inputName" ).value;
    var fromInputPhone = document.getElementById( "inputPhone" ).value;
    var fromInputAddress = document.getElementById( "inputAddress" ).value;

    var jsonToSend = JSON.stringify({
      "name": fromInputName,
      "phone": fromInputPhone,
      "address": fromInputAddress
    });
    console.log( "sent: " + jsonToSend );

    xhr.send( jsonToSend );
    xhr.onload = function () {
      console.log( "received: " + this.responseText );
    }

}


return (<div className="App">
    
    <h1>Customer List</h1>

  <div className="form">
    <label> Name </label>
      <input type="text" id="inputName" name="inputName"/>
    <label> Phone </label>  
      <input type="text" id="inputPhone" name="inputPhone" />
    <label> Address </label>  
      <input type="text" id="inputAddress" name="inputAddress" />
    <button type="button" onClick={create}>Submit</button>
    <button type="button" onClick={create}>Update</button>
    
    
      </div>

    <div>
      <Listing />
    </div>
  


  </div>
  )
  
}

export default App;
