package Time;

public class Time {

public static final Time MIDDAY = new Time(12);
public static final Time MIDNIGHT = new Time(0);
private int total_seconds;


public Time(){
  total_seconds = 0;
}

public Time(int a, int b, int c){
  this.total_seconds = (a*3600) + (b*60) + (c);
}

public Time(int a, int b){
  this.total_seconds = (a*3600) + (b*60);
}

public Time(int a){
  this.total_seconds = (a*3600);
}


public int hours(){
  return (int)(total_seconds/3600);
}

public int minutes(){
  return (int)((total_seconds - (this.hours() * 3600))/60);
}

public int seconds(){
return (int)(total_seconds - ((this.hours() * 3600) + (this.minutes() * 60)) );
}

@Override
public boolean equals(Object obj) {
    if(this == obj) return true;
    if(null == obj) return false;
    if(obj instanceof Time){
      Time tx = (Time) obj;
      if(this.hours() == tx.hours() &&
        this.minutes() == tx.minutes() &&
        this.seconds() == tx.seconds())
      return true;
    }
    return false;
  }

 public String toLongString(){
  String a = "";
  if(this.hours() > 24){
    a = (this.hours() % 24) + (this.hours() <= 1 ? " hora": " horas") + (this.minutes() > 0 ?((this.seconds() == 0? " e ": " ") +
        this.minutes() + (this.minutes()<=1 ? " minuto": " minutos")  +
         (this.seconds() > 0 ?" e " + this.seconds() + (this.seconds() <= 1 ? " segundo": " segundos"):"")):"");
   return a;
 }else{
  a = (this.hours()) + (this.hours() <= 1 ? " hora": " horas") + (this.minutes() > 0 ?((this.seconds() == 0? " e ": " ") +
        this.minutes() + (this.minutes()<=1 ? " minuto": " minutos")  +
         (this.seconds() > 0 ?" e " + this.seconds() + (this.seconds() <= 1 ? " segundo": " segundos"):"")):"");
   return a;
 }
 }

@Override
public String toString() {
  String a = " ";
  if(this.hours() > 24){
     a = String.format(("%02d:%02d:%02d"), ((this.hours() % 24)), this.minutes(),this.seconds());
    return a;
  }else{
    a = String.format(("%02d:%02d:%02d"), this.hours(), this.minutes(),this.seconds());
    return a;
  }
}

public Time plusHours(int x){
  Time ty = new Time();
  ty.total_seconds = this.total_seconds + (x * 3600);
  return ty;
}

public Time plusMinutes(int x){
  Time ty = new Time();
  ty.total_seconds = this.total_seconds + (x * 60);
  return ty;
}

public Time plusSeconds(int x){
  Time ty = new Time();
  ty.total_seconds = this.total_seconds + x;
  return ty;
}

public Time minusHours(int x) {
  Time ty = new Time();
  ty.total_seconds = this.total_seconds - (x * 3600);
  return ty;
}

public Time minusMinutes(int x){
  Time ty = new Time();
  ty.total_seconds = this.total_seconds - (x * 60);
  return ty;
}
public Time minusSeconds(int x){
  Time ty = new Time();
  ty.total_seconds = this.total_seconds - x;
  return ty;
}


public Time plus(Time t2) {
    Time ty = new Time();
    ty.total_seconds = this.total_seconds + t2.total_seconds;
    return ty;
}
/* FAZER AS VERIFICAÇÕES (TRY...CATCH) */

public Time minus(Time tx) {
  int i = this.total_seconds - tx.total_seconds;
  if (i < 0){
    i += 86400;
  }
  Time ty = new Time();
  ty.total_seconds = i;
  return  ty;
}

public boolean isMidDay() {
  boolean x = false;
  if(this.total_seconds == 43200){
    x = true;
  }else{
   x = false;
  }
  return x;
}

public boolean isMidNight() {
  boolean x = false;
  if(this.total_seconds == 0){
   x = true;
  }else{
   x = false;
  }
  return x;
}

public Time shift() {
  Time ty = new Time();
  int i = 0;
  i = this.total_seconds + 43200;
  ty.total_seconds = i;
  return ty;
}

public Time tick() {
  Time ty = new Time();
  int i = 0;
  i = this.total_seconds + 1;
  ty.total_seconds = i;
  return ty;
}

public static Time fromString(String string) {
  String hr = " ", mi = " ", se =" ";
  hr = string.substring(0,2);
  mi = string.substring(3,5);
  se = string.substring(6,8);
  Time ty = new Time();
  ty.total_seconds = (Integer.parseInt(hr) * 3600) + (Integer.parseInt(mi) * 60) + Integer.parseInt(se);
  return ty;


}

public static Time fromDouble(double d) {
  String a = String.valueOf(d), b = "";
  int j = 0, total = 0;
  double e = 0.0, k = 0.0;
  j = (int) (Double.parseDouble(a.split("\\.")[0]));
  total = j * 3600;
  e = (d - j) * 60;
  b = String.valueOf(e);
  k = (Double.parseDouble(b));
  j = (int) (Double.parseDouble(b.split("\\.")[0]));
  total += j * 60;
  e = (k - j) * 60;
  total+= e;
  Time ty = new Time();
  ty.total_seconds = total;
  return ty;
}

public static Time fromSeconds(int i) {
  Time ty = new Time();
  ty.total_seconds = i;
  return ty;
}

public double toDouble() {
  int hr = 0, mi = 0, se = 0;
  double c = 0.0;
  hr = this.hours();
  mi =this.minutes();
  se = this.seconds();
  c = hr;
  c += (double) mi/60;
  c += (double) se/3600;

  return c;
}

public static Time from(Time tx){
  Time ty = new Time();
  ty.total_seconds = tx.total_seconds;
  return ty;
}
//"13:22:04";
// 01 34 67
//String.format("%02d:%02d:%02d") -> usar para format

//Peço desculpas pelo código abaixo professor, não está bom. Infelizmente, não tenho mais tempo.
public String toShortString(){
  String a = "";
  boolean flag1 = true, flag2 = false, flag3 = false;
  if(this.minutes() >= 1){
    flag2 = true;
  }
  if(this.seconds() >= 1){
    flag3 = true;
  }
  if(this.hours() > 24){
    if(flag1 == true && flag2 == true && flag3 ==true){
      a = String.format(("%02dh%02dm%02ds"),((this.hours() % 24)), this.minutes(),this.seconds());
    }

    if(flag1 == true && flag2 == true && flag3 == false){
      a = String.format(("%02dh%02dm"),((this.hours() % 24)), this.minutes());
    }

    if(flag1 == true && flag2 == false && flag3 == true){
      a = String.format(("%02dh%02dm%02ds"),((this.hours() % 24)), this.minutes(),this.seconds());
    }

    if(flag1 == true && flag2 == false && flag3 == false){
      a = String.format(("%02dh"),((this.hours() % 24)));
    }
   return a;
 }else{
  if(flag1 == true && flag2 == true && flag3 ==true){
    a = String.format(("%02dh%02dm%02ds"),((this.hours() % 24)), this.minutes(),this.seconds());
  }

  if(flag1 == true && flag2 == true && flag3 == false){
    a = String.format(("%02dh%02dm"),((this.hours() % 24)), this.minutes());
  }

  if(flag1 == true && flag2 == false && flag3 == true){
    a = String.format(("%02dh%02dm%02ds"),((this.hours() % 24)), this.minutes(),this.seconds());
  }

  if(flag1 == true && flag2 == false && flag3 == false){
    a = String.format(("%02dh"),((this.hours() % 24)));

  }

  return a;
 }
}

public int toInt() {
  return this.total_seconds;
}


}
