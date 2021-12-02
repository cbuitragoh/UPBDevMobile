package Controllers;


import java.util.ArrayList;
import java.util.List;

import Interfaces.InicioInterface;
import Models.PublicacionesDTO;

public class ControladorInicio implements InicioInterface.Controlador {

    private final InicioInterface.View view;

    public ControladorInicio(InicioInterface.View view) {
        this.view = view;
    }

    @Override
    public void recuperarLista() {

        List<PublicacionesDTO> publicacionesDTOList = new ArrayList<>();

        PublicacionesDTO  publicacionesDTO =  new PublicacionesDTO();
        publicacionesDTO.setId("12");
        publicacionesDTO.setComentario("asd");
        publicacionesDTO.setFecha("asd");
        publicacionesDTO.setNombre_alimento("sadas");
        publicacionesDTO.setTipo_alimento("dsas");

        publicacionesDTOList.add(publicacionesDTO);

        PublicacionesDTO  publicacionesDTO1 =  new PublicacionesDTO();
        publicacionesDTO1.setId("12");
        publicacionesDTO1.setComentario("asd");
        publicacionesDTO1.setFecha("asd");
        publicacionesDTO1.setNombre_alimento("sadas");
        publicacionesDTO1.setTipo_alimento("dsas");

        publicacionesDTOList.add(publicacionesDTO1);

        PublicacionesDTO  publicacionesDTO2 =  new PublicacionesDTO();
        publicacionesDTO2.setId("12");
        publicacionesDTO2.setComentario("asd");
        publicacionesDTO2.setFecha("asd");
        publicacionesDTO2.setNombre_alimento("sadas");
        publicacionesDTO2.setTipo_alimento("dsas");

        publicacionesDTOList.add(publicacionesDTO2);

        PublicacionesDTO  publicacionesDTO3 =  new PublicacionesDTO();
        publicacionesDTO3.setId("12");
        publicacionesDTO3.setComentario("asd");
        publicacionesDTO3.setFecha("asd");
        publicacionesDTO3.setNombre_alimento("sadas");
        publicacionesDTO3.setTipo_alimento("dsas");

        publicacionesDTOList.add(publicacionesDTO3);

        view.mostrarLista(publicacionesDTOList);

    }

    @Override
    public void salirApp() {
        view.respuestaSalirApp();
    }

}

