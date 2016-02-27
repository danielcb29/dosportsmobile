package dosports.dosports;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {


    private String[] eventos_creados={"Fútbol 7 \n     Pabellón Multiusos                       Ver más +\n     01/04/2016 - 21:30",
            "Baloncesto \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00",
            "Béisbol \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00"
    };


    private String[] eventos_suscritos={
            "Baloncesto \n     Pista La Madrila                            Ver más +\n     15/03/2016 - 17:00",
            "Béisbol \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00",
            "Volleyball \n     Pabellón Moctezuma                    Ver más +\n     09/03/2016 - 11:30"};

    public Perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ListView listaEventos=(ListView)view.findViewById(R.id.listaEventosCreados);
        ListAdapter la = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,eventos_creados);
        listaEventos.setAdapter(la);


        ListView listaEventosSuscritos=(ListView)view.findViewById(R.id.listaEventosSuscritos);
        ListAdapter la2 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,eventos_suscritos);
        listaEventosSuscritos.setAdapter(la2);

        return view;
    }


}
