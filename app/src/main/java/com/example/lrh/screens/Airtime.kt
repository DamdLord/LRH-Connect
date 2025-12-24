package com.example.lrh.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lrh.R
import com.example.lrh.data.AsyncImageI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Airtime(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    var phoneNumber by rememberSaveable{ mutableStateOf("") }
    var amount by rememberSaveable{ mutableStateOf("") }
    var selectedOption by rememberSaveable{ mutableStateOf("") }
    var bypassValidatorChecked by rememberSaveable{ mutableStateOf(false) }
    var isSelectNetworkDropdownExpanded by rememberSaveable{ mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = onBackClick
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = modifier.size(35.dp)
                            )
                        }
                        Text(
                            text = "Airtime",
                            fontSize = 27.sp,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )

                    }
                },
                expandedHeight = 40.dp
            )
        }
    ) {innerPadding->
        Column(
            modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Card(
                modifier
                    .fillMaxWidth()
                    .height(550.dp),
                //elevation = CardDefaults.elevatedCardElevation(10.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
            ) {
                Box(
                    modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column(
                        modifier.fillMaxWidth()
                    ) {
                        ScrollingText("2% discount on every purchase")
                        Card(
                            modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onPrimary)
                        ) {
                            Column(
                                modifier
                                    .fillMaxSize()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.Start,
                                ) {
                                ExposedDropdownMenuBox(
                                    expanded = isSelectNetworkDropdownExpanded,
                                    onExpandedChange = {
                                        isSelectNetworkDropdownExpanded =
                                            !isSelectNetworkDropdownExpanded
                                    }
                                ) {
                                    OutlinedTextField(
                                        value = phoneNumber,
                                        onValueChange = { phoneNumber = it },
                                        readOnly = false,
                                        singleLine = true,
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
                                        maxLines = 1,
                                        leadingIcon = {
                                            Row(
                                                modifier.wrapContentSize(),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.Start
                                            ) {
                                                when (selectedOption) {
                                                    "MTN" -> {
                                                        AsyncImageI(
                                                            "data:image/png;base64,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"
                                                        )
                                                    }
                                                    "GLO" -> {
                                                        AsyncImageI(
                                                            "data:image/jpeg;base64,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"
                                                        )
                                                    }
                                                    "AIRTEL" -> {
                                                        AsyncImageI(
                                                            "data:image/png;base64,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"
                                                        )
                                                    }
                                                    "9MOBILE" -> {
                                                        AsyncImageI(
                                                            "data:image/png;base64,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"
                                                        )
                                                    }

                                                    else -> AsyncImageI(
                                                        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAk1BMVEX/xAMAAAD/yAP/zAP/xgP/ygP/xwP/zQNTQAGvhwKadgIbFQGEZQGogQLgrAOxiAL5vwOjfQLPnwNkTQHutwOUcgLZpwMfGAC5jgKPbgJxVwFpUQHAkwLVpAMwJQDnsgN7XgE/MQAsIgBKOQCIaAI6LAHImgJcRgEXEQAmHQAMCQA7LQF2WgGQbgJ+YAFtVAFNOwCwdC7BAAAHg0lEQVR4nO2caVviPBSGQ1aKUAoUBFkKyoDjMOr//3Vvt3RhaxjTou/13F+UQpPzpMnJekoIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA7gDnklIRw2KS/ymVkvN7G/cVOKexJO67w0W/15l110/zUcj84/C+HXd608XS9Xms+KdJjbQx5rmLQXf0p1XFr1F3sHNJKJT+CJ2hOEUm/W27Utkx7W1/QlQo894SriAFo65z+H2zuJzfB8elTHxHlZwyuuzc/uTOsR9MwrL6Viq5UL4zsqJOM3J89V0eZSjP7awumrraH/4O+ovhJPB9z4vckOd5fuAuQwc7mB3az5fv7LjfQCSnKug8njWw3e3tXC/p/uKur4yUkiY9pOfuetv92TQeO4G6a3Xlgk83p3Ztus7SU6H3N+vmohGBYMqb9LvnEusTdi+NUgXdE4PmvQmPtd2cXNyLhr744yTNbqBkDfZXQdXw2HOOnICxL3bboU9mwYnXag8VtWW4IZItys7lYba05uFDlWK5fSilv1qwJp8jV7uSC3wYh17PrgEy9NDj12ImzzvVVHvkzH0pZv2+rGcQwgWbvBczenGb8TnCOxRy/TXlNVYfyXi/2BoOnqgtLw1X00KO80nd3VXY4S6Lfmdad1WlXqFr7vqNtH7Jgqc8071Xq1dlw0Lz8xrriTnzCxqHrL6MVCcvSr/RkQZnQd77juuqqZxmNfRh2JjnznJXu6zz2NczIOfkV1aIljs/MyidaQP+kBokck9PIR7c+hrCdROYqx/jo2ddIida4Ie8xwNMkHKuJdp+ilzqjrfXeAss2aEGeqhhuSNW2snU6KrNYDvtbpTVZHU3Mbk8akrXs0vX0kVu/eUp525LrlxsCmKS2tKxWNjSTRN1LwsUL+2Qz3WxZNn4M7q4kSL+e8pGsvjvZze/TWyiKy+LaomuPYcgUi8zvDLuZWm2Tv4bqU2h+ssTsm8G7Cgh5/LgTKQV9be1YbhIW3fvWrXIRAS6ZDnVvl1UK8xLr1ohYdogSxI5MWnamamP2smxrb5korDlS2OFmeOz1GWI1M1c72RzU5+SksjqqKHCh3SBx0Qh95IfDew8RGFUJQoipvEvRb6MelmhLHzTVsYKieglv7LiTmXariuKqyjCD58Gm+WfKU93SHV/vVXJZ1G6baaMFepiH9pwp2JtVCGKpq5E3sHECrO00grfFeduay0EMVaYlNW7jWqa5lg11C2Z2lWiuMdmqjDu4cwUcj/+1auFgU2a1EtVUmVTh53iJ2OFUTmaKSRqE//M/7o3TZvhuKo6lE19K30yV7hh3FChSNq5hYZInTiladX6T2pYaSVc19RqhdlmxUEZKqRTM7uqSZt0ZVmlhk2LmxlLY4X9vr6np8wUymRRzEKPmCpcGip0SC5wrYwV9tRa3+UaKlxaVmj6DJ18wfFNCnOFgumdgremn6Fpfc+aD/ur6yi9QSHVAzFNc+0wLStTXxoaxjaJCkZuUUhkcJNCe770xv4wNCx5Gq/hFOMmhdm0z0yhSmq1hf6QsKRhGI5pIsPoxOk7Lic3KszXSgwUppX6zcZijUj28Kpmm8VujFMaTxJvVEjUyFihzXFp2hBfKyYq5zrqWxVyujJW+GarGeZG9I3mh19SSAoOtWJ+mIy07MwPs2Wa60sGVhSGTdhIoeU5vl6nmZus03xRIRFTE4W6wdo6kKofYt9gre2rConaVitkaR21tdYWpphOEq6seIemPoQcK3yILxYVRhfetrnC19foF7lCwvbxlf6V9dJ0RP9sb9E7W5IIrhVsDD1zrWCIOFnEP73tXEJFaLYCb3FvRi/BtoL6T3tUIbTAgdVNomzv6VpFbQSmJ50jq3tPhEu9xT21m/Ctdig9Vba9f1jY5O7e8dyuFPo8lvU94KLEVXCvXVIW6AODNezjl85iDBo9CamR+dxjVcdZjNJ5mufJHc7TLLNF5v0/HEE2zCSfwH00fSbKn2d513YmipTPtW2bPNfmFU6U13tYonQ2cdvMcwz1bfNMaz6beHy+9Mmt/YQ5VW7xxG7t50tDBFkXcnxZ0Br7Ry7Eonjiek0aGVIdn/Pe1hS8E4UbzYoZNXXOO8pbDUs7MM+dwPZZ/VBe0CkFBKyaPfEp2a4cb7Ea24uoi6JKJuNyGONq13jcDFW7Ul2N/M7U/3IMaBSD6k+fjlK+Q8xMhFTu+siS1uuh74p/i+iN456E2z+8HSd6p7in2ChGnF/H9rRan9upy2+OXSPudHtcK1r3jV2LrbsYf/g4mjm7gKij+MNYURqASONwdkWCoTMbnU/k3vGHicjrMaR/9utZIYZUilBlEkS6m/bG76PNxTufx98hhjThfx4HnJDEcn9aUdfuLOU3i+VOkYLJSe9wPizYjOdDb0LZXYIdTIn6M2/pdG9/mj/hnQqa2Pun78W47II00XsxFhPvx7wXI0e/24QcvdtkPv94WndnncjB/tR3m5ThJ++nyV9Q86OFAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP5j/AIh9Yoi2lqACAAAAAElFTkSuQmCC"
                                                    )
                                                }
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectNetworkDropdownExpanded)
                                            }
                                        },
                                        trailingIcon = {
                                            // ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectNetworkDropdownExpanded)
                                        },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color(0xFFF3F3F3),
                                            focusedContainerColor = Color(0xFFF3F3F3),
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent,
                                            disabledIndicatorColor = Color.Transparent,
                                            cursorColor = MaterialTheme.colorScheme.primary
                                        ),
                                        modifier = modifier
                                            .wrapContentSize()
                                            .fillMaxWidth()
                                            .menuAnchor()
                                    )

                                    ExposedDropdownMenu(
                                        expanded = isSelectNetworkDropdownExpanded,
                                        containerColor = MaterialTheme.colorScheme.primary,
                                        onDismissRequest = {
                                            isSelectNetworkDropdownExpanded = false
                                        },
                                        matchAnchorWidth = false
                                    ) {
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImageI(
                                                    "data:image/png;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "MTN",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "MTN"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        Spacer(modifier.height(5.dp))
                                        HorizontalDivider()
                                        Spacer(modifier.height(5.dp))
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImageI(
                                                    "data:image/jpeg;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "GLO",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "GLO"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        Spacer(modifier.height(5.dp))
                                        HorizontalDivider()
                                        Spacer(modifier.height(5.dp))
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImageI(
                                                    "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADgCAMAAADCMfHtAAAAk1BMVEXjBhP////iAADjAAvjAA/mMDfnRkv75+T99vbkHx774dz3z9DrdXjpW1/uiIT2xcDjAAftfXjrbmvzsK31vrv3ysfmNzbwl5T40s/vjontgX786ufypqPpXVv+9fPyqqfoUU7qZmPsdXLoUU/qY2HnREH0uLXlLy7xoJ352dbwlJHxp6nnQT3lKSfpWFXra2nnTFBhQ3fWAAAIf0lEQVR4nO2deXuqOhDGYeDW5d6jaEVFK2rrUntczvf/dJctG0ZUykDnPHn/ExH4NWEmmUym1otj/eUyhPRlCOnLENKXIaQvQ0hfhpC+DCF9GUL6MoT0ZQjpyxDSlyGkL0NIX4aQvgwhfRlC+jKE9GUI6csQ0pchpC9DSF+GkL4MIX0ZQhS5HqSq4+a1E8Zg1mo4C4JgsDjVQFkroRsBbd6mbVvo8HkEcDFvWiNhhDfz7WvNg6hV8VQbIcC5r8FL1J4hNmNNhFHzzW/xJZ3VQ2vGWggBgrCIL9YKC7EGQoDBXb5IayREdEIXVq0H+CJtcBCxCQFGj/FFGnsYT4BL6MD7w3yR20CxqKiEYE2fALTtN4x+ikjoPtWAiToIT4NH6DzxBjLtEBoRjRA6hS7+hhDeRCxCWJXgs+1Z9Y2IRAiLUoB2nwphyRa07ZAIodMpCWjbTuUvIgahC2WMTKpV5eMaDMISboKr+vE3AiFcygPaFwKELrTvg8TqLnvvs9fcyRQIYfkI3nzSySKK6um/fj6haz3Ad1jzKKKrIu4r/4tXTghv9/k+lOAayBGA6odt1RPeewvnm1zwED7FlwQ8/t3h2nVwFM7iW58AYXEn9d1rBPnNnRAg/LeAr73WvWYuiDO21YdqKifs3gYc6aP3EiHCa1gjob4BI3lbfs4rBULd2ktBA8Y/GWB20uoJg+caMP7JKzurRSHWJpsNodei9TPh8XsUCC3oXfH546KRiifiAUQiwvIQJeHbFi9kA19WRHCGFtL8UAw0558dKLYezom/qzjLpChzfLjsDq3WYdfb309EEE2I8haixdoeziYB7gxRDKnVfMYQ8MXFI8raWl2EWZNqvvhigJ+EV7ktB86jyPh0g6te640ZYJdypgLsD8yyWurdpMCqhfYc+IQwE74x11LCjp7xcobQCdUBgEICE3YYYcmJCz1TQR3hyCgwRLcysZAJpZlRIingK8IzS0xAZEJhKzOJgZlYgMOY9krCJYRcstCQwwhAlAQMSbjZJrmZlJg8iKDjFzIgMmF4C5DnobxjA6ISyp5Qbi1XuIkPdEBcQiXuxh2FSLSZn/ABMQnF3FYxMmAx8+PfmRxXI0RCxc6w1WsXNuxQgJvBzoRJuLtuQeChw/BYQw+NhUkoEhMzKxpNo5h13aHm58vCJGSTJnue0LhwYgHx8FxPD41VSxvGfgLA5b32rbYGtHAJebR+BgAfPMmmWxggrlyYhGv+HvZ9MboZ1OIjhFA9vmYTQq0dNBEq4TrPt7Rq7aCJcEfeXzJeK0DepaYX8vxwwYam+Lvwbgk7igGdYa/3vq1pv6hO6LE2Jw5212s9VTW9boEvQ0hfhpC+DCF9GUL6MoT0ZQjpC4Ewnk00MhPUq/o9M3AMJsPaozG3VX0GbRL1bSOmjzypyrOg2cISRsp2KVVMKNK8D3ca0XkmrhGXzir7SFUT8rWKgpTmJItvPHzbPnTv5Oxzr3RKStWEIgh8vHVlGL75SV9+aK8hzJbT5KI/hVAsbHu32pCn6z1CyHP/2z+FkCd53U755caIJKHYBHzbXdAmtLxT2gcL8mSIE8ZlhV53QVFxMkKEnj4hH7Tj0iT2DbH5KSCM/Z6nXK85wrgE4nYw+f37c5BfckkrWyqHos/7YW/yNTtHnpsT/lHT2+NLrtaX1Uk92AxhxNATmRbhUtr7mrjn16l9cqVDlz7f/9wFNWEx4JlE3idzI/6Gd4xmCB3Y5ksg8v0uMMp8focRejCT14KnekJXXWvs7nmGUQOEzlhTwYulwXKXzwjhqOaYnrWELuSv+cHIGyB0nWtA3op5wnyKaQssHeEVoG2fnMYIpTQSWZarIbw6daAl1NXS6EJzhFkJof7X5ni88DSZdPCvEkpPHr6+r7abOP2LE4aR2nHbey/srHa/z1/aJBeuIVsazeOnl8QVRl6OdcNQR8h35w9iZ5jO8q69BZ9z7eID7G92aJDQ2W6Fy+ITpqQsyQ3C/+R9FnmPz/fJHmIvKrYKxRX4mvKHjvQrvj89SSEtQ8jTNFP7yf1G3IGbHbW5ifjzDUoTtuV+LioQjBoljIdY0InF35teSUJO5LOtp9nnVoOEEd+sn89aK0vIo1f+ephoza7YHKGX35H+PcKd5mIpoduUx99rKx+XJrxZxnXsNEPo7fXPU5rwZiXlF68Zwls1A0sT3qxBuGqGUJrmtL4Wi8WKdbJvEx76qvxtM71UBH0nqW1nc8VvE24gp2bGNKIi0Ch7wG8Tsp/o4nMNEIoJX1Ye7/uEygVyaoKQuUJWter7hGyvnm43aROErCDbvCpCPrWY/hDCIHfL8oTsXwVw25WLSqZf1k7ofWS3ZMVInidk890BI2ShDnlPMEAaj+R1p2r0Fiz02S9rS9lkhBVJdPggacyOAAzDnRo0WJRELEHIKyMuE6e1Z53uYUJujScsisGDPbPUEY6T4HBSDYSPy8Ottv4LAqFcr6y/88WQK3iQULpA2x+tQb3kwfdZL05isFJlzLk/KoFYZly6sXVque5jhGrsMP276GuCWsoVY9VDqCvJFofJNPFSPaErzyayiPAsf71IYfJwSuWJmgilqiRM80Vm6R8hjAyJSNnI1i00JbIn2UYUuYJrXYQWuEpR8uma2wDePCkhI1EJo1bk//6JeQjwlKn+/Ess0IHF71YbYfSITtBvhWHY8pcX2cbBcJBoln5aZ5+uUk8ie9lbjvq7T55U4wL0+gl3y5+oa5LRV+9vfd/flSlkUzqa6IpJTn4xVFr4LCjc5lx9I10yf76rXPUpmfxS+jKE9GUI6csQ0pchpC9DSF+GkL4MIX0ZQvoyhPRlCOnLENKXIaQvQ0hfhpC+DCF9GUL6MoT0ZQjpyxDSlyGkL0NIX4aQvl489++W9eufv1z/A4hzd1H4JqS9AAAAAElFTkSuQmCC"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "AIRTEL",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 18.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "AIRTEL"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )
                                        Spacer(modifier.height(5.dp))
                                        HorizontalDivider()
                                        Spacer(modifier.height(5.dp))
                                        DropdownMenuItem(
                                            leadingIcon = {
                                                AsyncImageI(
                                                    "data:image/png;base64,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"
                                                )
                                            },
                                            text = {
                                                Text(
                                                    text = "9MOBILE",
                                                    color = MaterialTheme.colorScheme.onPrimary,
                                                    fontSize = 20.sp
                                                )
                                            },
                                            onClick = {
                                                selectedOption = "9MOBILE"
                                                isSelectNetworkDropdownExpanded = false
                                            }
                                        )

                                    }
                                }
                                Spacer(modifier.height(10.dp))
                                Text(
                                    "Amount"
                                )
                                Spacer(modifier.height(10.dp))
                                OutlinedTextField(
                                    value = amount,
                                    onValueChange = { amount = it},
                                    readOnly = false,
                                    maxLines = 1 ,
                                    modifier = modifier.fillMaxWidth(),
                                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done)
                                )
                                Spacer(modifier.height(10.dp))
                                Row(
                                    modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start
                                ) {
                                    Checkbox(
                                        checked = bypassValidatorChecked,
                                        onCheckedChange = { bypassValidatorChecked = !bypassValidatorChecked}
                                    )
                                    Text(
                                        text = "Bypass validation"
                                    )
                                }
                                Spacer(modifier.height(10.dp))
                                Button(
                                    onClick = {},
                                    shape = RectangleShape,
                                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
                                    modifier = modifier.fillMaxWidth().height(50.dp)
                                ) {
                                    Text(
                                        "Purchase",
                                        color = MaterialTheme.colorScheme.onPrimary
                                    )
                                }
                            }
                        }
                    }
                }

            }
        }

    }

}