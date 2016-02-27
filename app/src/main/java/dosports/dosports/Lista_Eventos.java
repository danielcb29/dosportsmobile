package dosports.dosports;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lista_Eventos extends Fragment {


    private String[] eventos={"Fútbol 7 \n     Pabellón Multiusos                       Ver más +\n     01/04/2016 - 21:30",
            "Baloncesto \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00",
            "Volleyball \n     Pabellón Moctezuma                    Ver más +\n     09/03/2016 - 11:30",
            "Pádel \n     Pista La Madrila                            Ver más +\n     15/03/2016 - 17:00",
            "Fútbol \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00",
            "Tenis \n     Pabellón Moctezuma                    Ver más +\n     09/03/2016 - 11:30",
            "Baloncesto \n     Pista La Madrila                            Ver más +\n     15/03/2016 - 17:00",
            "Béisbol \n     Pista Los Fratres                           Ver más +\n     17/03/2016 - 18:00",
            "Volleyball \n     Pabellón Moctezuma                    Ver más +\n     09/03/2016 - 11:30",
            "Pádel \n     Pista La Madrila                            Ver más +\n     15/03/2016 - 17:00"
    };

    public Lista_Eventos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista__eventos, container, false);

        ListView listaResultadosBusqueda=(ListView)view.findViewById(R.id.listaEventos);
        ListAdapter la = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,eventos);
        listaResultadosBusqueda.setAdapter(la);

        listaResultadosBusqueda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Evento ev=new Evento();
                ev.setPosicion(position);
                transaction.replace(R.id.container,ev).addToBackStack(null).commit();
            }
        });
        return view;
    }


}
