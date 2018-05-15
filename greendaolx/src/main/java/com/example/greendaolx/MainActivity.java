package com.example.greendaolx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greendaolx.adapter.MyAdapter;
import com.example.greendaolx.dao.DaoSession;
import com.example.greendaolx.dao.UserDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*
    //增加
    songDao.insert(song);
    //改
    song.setSingerName("miss08");
    songDao.update(song);
    //查
    Song query = songDao.queryBuilder().where(SongDao.Properties.SingerCode.eq(111))
            .list().get(0);
    //删
    songDao.delete(song);
*/
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_age)
    EditText edAge;
    @BindView(R.id.daoselect)
    Button daoselect;
    @BindView(R.id.daoadd)
    Button daoadd;
    @BindView(R.id.daoupdate)
    Button daoupdate;
    @BindView(R.id.daodelete)
    Button daodelete;
    @BindView(R.id.dao_rec)
    RecyclerView daoRec;
    @BindView(R.id.ed_address)
    EditText edAddress;
    @BindView(R.id.ed_id)
    EditText edId;
    @BindView(R.id.daodeleAll)
    Button daodeleAll;
    private DaoSession daoSession;
    private UserDao userDao;
    private User user;
    private String name;
    private String age;
    private String address;
    private List<User> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        //获取Song这张表的操作类SongDao
        daoSession = DaoSessionManager.getInstace().getDaoSession(this);
        userDao = daoSession.getUserDao();
    }

    @OnClick({R.id.daoselect, R.id.daoadd, R.id.daoupdate, R.id.daodelete,R.id.daodeleAll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.daoselect:
                select();
                break;
            case R.id.daoadd:
                //添加
                inster();
                break;
            case R.id.daoupdate:
                update();
                break;
            case R.id.daodelete:
                delete();
                break;
            case R.id.daodeleAll:
                userDao.deleteAll();
                select();
                break;
        }
    }

    private void update() {
        String id = edId.getText().toString().trim();
        if (id.isEmpty()){
            Toast.makeText(this,"请输入要修改的id值~",Toast.LENGTH_SHORT).show();
        }else{
            User user = userDao.queryBuilder().where(UserDao.Properties.Id.eq(id)).build().unique();
            if (user!=null){
                String sName  = edName.getText().toString().trim();
                String sAge  = edAge.getText().toString().trim();
                String sAddress = edAddress.getText().toString().trim();
                if (sName.isEmpty()||sAge.isEmpty()||sAddress.isEmpty()){
                    Toast.makeText(this,"不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    user.setName(sName);
                    user.setAge(sAge);
                    user.setAddress(sAddress);
                }
                Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                select();
            }else{
                return ;
            }
        }

        kong();
    }

    //删除
    private void delete() {
        String id = edId.getText().toString().trim();
        if (id.isEmpty()){
            Toast.makeText(this,"请输入要删除的id值~",Toast.LENGTH_SHORT).show();
        }else{
            userDao.queryBuilder().where(UserDao.Properties.Id.eq(id)).buildDelete().executeDeleteWithoutDetachingEntities();
            Toast.makeText(this,"删除成功~",Toast.LENGTH_SHORT).show();
            select();
        }
        kong();
    }

    //查询
    private void select() {
        list = userDao.queryBuilder().list();
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        daoRec.setLayoutManager(manager);
        myAdapter = new MyAdapter(MainActivity.this, list);
        daoRec.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    //添加
    private void inster() {
        name = edName.getText().toString().trim();
        age = edAge.getText().toString().trim();
        address = edAddress.getText().toString().trim();
        if (name.isEmpty() || age.isEmpty() || address.isEmpty()) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
        } else {
            userDao.insert(new User(null, name, age, address));
            //置空
            kong();
        }
        Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();

    }

    private void kong() {
        edId.setText("");
        edName.setText("");
        edAddress.setText("");
        edAge.setText("");
    }


}
