package cl.danielacorral.meli.service;

import cl.danielacorral.meli.DTO.UrlDTO;
import cl.danielacorral.meli.IUrlshortenerRepository;
import cl.danielacorral.meli.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrlshortenerService implements IUrlshortenerService {

    private static final String referenceTable = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    IUrlshortenerRepository iUrlshortenerRepository;

    @Override
    public String createShortURL(String longUrl) throws Exception {
        if( this.validateUrlIsBlank(longUrl) == false && !this.validateUrlExist(longUrl)){
            // Step-1: Generate a unique ID for the new URL entry
            String uuid = UUID.randomUUID().toString().replace("-", "");
            long numericID = 1;

            for (int i = 0; i < uuid.length(); i++) {
                char letra = uuid.charAt(i);
                int letraeEnNumero = (int) letra;

                if (letraeEnNumero >= 48 && letraeEnNumero <= 57) { // Si es un dígito (0-9)
                    numericID += (letraeEnNumero - 48);
                } else if (letraeEnNumero >= 65 && letraeEnNumero <= 90) { // Si es una letra mayúscula (A-Z)
                    numericID += (letraeEnNumero - 65 + 11);
                } else if (letraeEnNumero >= 97 && letraeEnNumero <= 122) { // Si es una letra minúscula (a-z)
                    numericID += (letraeEnNumero - 97 + 73);
                }
            }

            // Agregar aleatoriedad con un "salt"
            int numeroAleatorio = (int) (Math.ceil(Math.random() * 100) * 23 * 7);
            numericID = numericID * numeroAleatorio;

            // Step - 2: Conversión a base 62
            String genHashVal = "";
            long dummyId = numericID;

            while (dummyId > 0) {
                int rem = (int) (dummyId % 62);
                genHashVal += referenceTable.charAt(rem);
                dummyId = Math.floorDiv(dummyId, 62); // División entera en Java
            }

            // Step-3: Generar la URL corta a partir del valor hash
            String hashValue = genHashVal;
            String shortUrl = "http://localhost:8080/meli/" + hashValue;

            UrlEntity urlEntity = new UrlEntity();
            urlEntity.setLongurl(longUrl);
            urlEntity.setShorturl(shortUrl);

            //paso -4 guardar url corta
            iUrlshortenerRepository.save(urlEntity);
            return shortUrl;

        }else if (!validateUrlIsBlank(longUrl) && this.validateUrlExist(longUrl)){
            UrlDTO shortURL = getShortURL(longUrl);
            return shortURL.getShortUrl();
        }else {
            throw new Exception("La URL proporcionada está vacía o no es válida.");
        }

    };

  /*      // Step-1: Generate a unique ID for the new URL entry
        String uuid = UUID.randomUUID().toString().replace("-", "");
        long numericID = 1;

        for(int i = 0 ; i < uuid.length(); i++ ){
            //TODO: cambiar el nombre "letra" porque puede ser un numero tambien en la url
            char letra = uuid.charAt(i);
            //Todo: "parsear" esa letra a numero y tambien cambiar el nombre
            int letraeEnNumero = (int) letra;
            if(letraeEnNumero >= 48 && letraeEnNumero <= 57){
                numericID += (letraeEnNumero - 48);
            }else if (letraeEnNumero >= 65 && letraeEnNumero <= 90) {
                numericID += (letraeEnNumero - 65 + 11);
            } else if (letraeEnNumero >= 97 && letraeEnNumero <= 122) {
                numericID += (letraeEnNumero - 97 + 36);
            }
        }

        /**
         *  Como el resultado del for podría ser un número muy común
         *  se sigue agregando aleatoriedad

        // con Math.ceil lo redondeo un número al entero más cercano hacia arriba para evitar que salga 0.
        int numeroAleatorio = (int) (Math.ceil(Math.random()+100)*23*7);
        numericID = numericID * numeroAleatorio;

        // Step - 2: Base 62 conversion
        String base62 = "";
        Long numeroFicticio = numericID;

        while (numeroFicticio > 0) {
        //    int rem = numeroFicticio % 62;
          //  genHashVal += referenceTable[rem];
            numeroFicticio = Math.floorDiv(numeroFicticio, 62); // División entera en Java
        }

        return "Aqui va la urlcorta";
    }
    */

    @Override
    public UrlDTO getLongURL(String shortURL) {
        UrlEntity urlEntity = iUrlshortenerRepository.findUrlLong(shortURL);
        return buildDTOFromEntity(urlEntity);
    }

    @Override
    public UrlDTO getShortURL(String LongURL) {
        UrlEntity urlEntity = iUrlshortenerRepository.findUrlShort(LongURL);
        return buildDTOFromEntity(urlEntity);
    }

    private UrlDTO buildDTOFromEntity(UrlEntity urlEntity){
        UrlDTO urlDto = new UrlDTO();
        urlDto.setId(urlEntity.getIdUrl());
        urlDto.setLongUrl(urlEntity.getLongurl());
        urlDto.setShortUrl(urlEntity.getShorturl());
        return urlDto;
    }

    private boolean validateUrlExist(String url) {
        List<UrlEntity> urlsExist = iUrlshortenerRepository.findAll();
        boolean exist = false;
        for (UrlEntity urls : urlsExist) {
            if (urls.getLongurl().equals(url)){
                exist = true;
                break;
            }
        }
        return exist;
    }

    private boolean validateUrlIsBlank(String longuUrl) {
        return longuUrl.isBlank();
    }
}
