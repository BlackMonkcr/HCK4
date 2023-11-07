import React from 'react';
import {DataGrid} from 'devextreme-react/data-grid';
import CustomStore from 'devextreme/data/custom_store';

const store = new CustomStore({
  key: 'id',
  load(loadOptions) {
      return fetch(`http://localhost:8080/tipos`)
    .then((response) => response.json())
    .then((data) => {
      console.log(data); // Muestra el contenido de data en la consola

      data.map((item) => {
        item.grupos = item.grupos.map((grupo) => grupo.id);
        return item;
      })
      
      return {
          // extraer los id de la lista "grupos" dentro de data y asignarlos a "data"
          data: data
      };
  })
  .catch(() => { throw new Error('Data Loading Error'); });
  }
});

export default function CourseTypeDatagrid() {

  return (
     <div className="App">
        <DataGrid id="dataGrid"
            dataSource={store}>
        </DataGrid>
    </div>
    );
};