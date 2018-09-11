package com.noobit.security.core.social.qq.api;

import lombok.Data;

@Data
public class QQUserInfo {
    String openId;
    String ret; // 返回码
    String msg; // 如果 ret < 0, 会有相应的错误信息提示,返回数据全部用UTF-8编码
    String nickname; // 用户在QQ空间的昵称。
    String figureurl; // 大小为 30×30 像素的QQ空间头像URL。
    String figureurl_1; // 大小为 50×50 像素的QQ空间头像URL。
    String figureurl_2; // 大小为 100×100 像素的QQ空间头像URL。
    String figureurl_qq_1; // 大小为 40×40 像素的QQ头像URL。
    String figureurl_qq_2; // 大小为 100×100 像素的QQ头像URL。需要注意, 不是所有的用户都拥有QQ的 100x100 的头像, 但 40x40 像素则是一定会有。
    String gender; // 用户性别

    // note: 此处属性只能比 qq 接口返回来的多, 而不能少
    String is_lost;
    String province;
    String city;
    String year;
    String constellation;
    String is_yellow_vip;
    String vip;
    String yellow_vip_level;
    String level;
    String is_yellow_year_vip;
}
