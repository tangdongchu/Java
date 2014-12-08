import android.app.Activity;
import android.net.TrafficStats;
import android.os.Bundle;
import android.view.Menu;
public class MainActivity extends Activity {
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       /** 获取手机通过 2G/3G 接收的字节流量总数 */
       TrafficStats.getMobileRxBytes();
       /** 获取手机通过 2G/3G 接收的数据包总数 */
       TrafficStats.getMobileRxPackets();
       /** 获取手机通过 2G/3G 发出的字节流量总数 */
       TrafficStats.getMobileTxBytes();
       /** 获取手机通过 2G/3G 发出的数据包总数 */
       TrafficStats.getMobileTxPackets();
       /** 获取手机通过所有网络方式接收的字节流量总数(包括 wifi) */
       TrafficStats.getTotalRxBytes();
       /** 获取手机通过所有网络方式接收的数据包总数(包括 wifi) */
       TrafficStats.getTotalRxPackets();
       /** 获取手机通过所有网络方式发送的字节流量总数(包括 wifi) */
       TrafficStats.getTotalTxBytes();
       /** 获取手机通过所有网络方式发送的数据包总数(包括 wifi) */
       TrafficStats.getTotalTxPackets();
       /** 获取手机指定 UID 对应的应程序用通过所有网络方式接收的字节流量总数(包括 wifi) */
       TrafficStats.getUidRxBytes(uid);
       /** 获取手机指定 UID 对应的应用程序通过所有网络方式发送的字节流量总数(包括 wifi) */
       TrafficStats.getUidTxBytes(uid);
   }
   public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.activity_main, menu);
       return true;
   }
}